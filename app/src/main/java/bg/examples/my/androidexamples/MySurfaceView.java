package bg.examples.my.androidexamples;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * Created by user on 1/31/2017.
 Second approach can be found here:
 http://stackoverflow.com/questions/11192757/android-rotate-bitmap-around-center-without-resizing
 */

public class MySurfaceView extends SurfaceView implements
        SurfaceHolder.Callback {

    private DrawThread drawThread;
    private Paint paint = new Paint();
    private Point location;

    Bitmap bmpFanatic;
    Bitmap mImage;
    int mImageResize = 1;
    boolean mRotate = true;

    int iDegree = 1;

    public MySurfaceView(Context context) {
        super(context);
        initialize();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    private void initialize() {
        getHolder().addCallback(this);
        setFocusable(true);

        bmpFanatic = BitmapFactory.decodeResource(getResources(),R.drawable.photo);
        mImage = BitmapFactory.decodeResource(getResources(),R.drawable.photo);

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(1);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStyle(Paint.Style.FILL);
        location = new Point(0, 200);
    }

    public void startThread() {
        drawThread = new DrawThread(getHolder(), this);
        drawThread.setRunning(true);
        drawThread.start();
    }

    public void stopThread() {
        drawThread.setRunning(false);
        drawThread.stop();
    }
    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }
    public void update() {
        location.x = location.x + 10;
        if(location.x > getWidth()) {
            location.x = 0;
        }
        // bmpFanatic = RotateBitmap(bmpFanatic, 1);
        iDegree++;
        if (iDegree > 360)
            iDegree = 1;
    }
    protected void renderImage(Canvas canvas)
    {
        Rect dest,drawRect ;

        drawRect = new Rect(0,0, mImage.getWidth(), mImage.getHeight());
        dest = new Rect((int) (canvas.getWidth() / 2 - mImage.getWidth() * mImageResize / 2), // left
                (int) (canvas.getHeight()/ 2 - mImage.getHeight()* mImageResize / 2), // top
                (int) (canvas.getWidth() / 2 + mImage.getWidth() * mImageResize / 2), //right
                (int) (canvas.getWidth() / 2 + mImage.getHeight()* mImageResize / 2));// bottom

        if(!mRotate) {
            canvas.drawBitmap(mImage, drawRect, dest, null);
        } else {
            canvas.save(Canvas.MATRIX_SAVE_FLAG); //Saving the canvas and later restoring it so only this image will be rotated.
            canvas.rotate(iDegree,canvas.getWidth() / 2, canvas.getHeight()/ 2);
            canvas.drawBitmap(mImage, drawRect, dest, null);
            canvas.restore();
        }
    }
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(location.x, location.y, 15, paint);

        canvas.drawBitmap(bmpFanatic,0,0, paint);
        renderImage(canvas);
    }

    class DrawThread extends Thread {
        private SurfaceHolder surfaceHolder;
        MySurfaceView mySurfaceView;
        private boolean run = false;

        public DrawThread(SurfaceHolder surfaceHolder,
                          MySurfaceView mySurfaceView) {
            this.surfaceHolder = surfaceHolder;
            this.mySurfaceView = mySurfaceView;
            run = false;
        }

        public void setRunning(boolean run) {
            this.run = run;
        }

        @Override
        public void run() {
            Canvas canvas = null;
            while (run) {
                try {
                    canvas = surfaceHolder.lockCanvas(null);
                    synchronized (surfaceHolder) {
                        mySurfaceView.onDraw(canvas);
                        mySurfaceView.update();
                    }
                } finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }
}
