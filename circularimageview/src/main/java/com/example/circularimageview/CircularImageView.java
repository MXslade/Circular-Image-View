package com.example.circularimageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CircularImageView extends android.support.v7.widget.AppCompatImageView {

    private int radius;
    private Paint paint;
    private RectF rectF;
    private Path path;

    public CircularImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        radius = 0;
        paint = new Paint();
        rectF = new RectF();
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cutOff(canvas);
    }

    private void cutOff(Canvas canvas) {
        int widthHalf = this.getMeasuredWidth() / 2;
        int heightHalf = this.getMeasuredHeight() / 2;

        radius = widthHalf > heightHalf ? heightHalf : widthHalf;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        //"cutting off" top of the image
        rectF.bottom = heightHalf - radius;
        rectF.left = 0;
        rectF.right = this.getMeasuredWidth();
        rectF.top = 0;
        canvas.drawRect(rectF, paint);
        //"cutting off" bottom of the image
        rectF.bottom = this.getMeasuredHeight();
        rectF.left = 0;
        rectF.right = this.getMeasuredWidth();
        rectF.top = heightHalf + radius;
        canvas.drawRect(rectF, paint);
        //"cutting off" left side of the image
        rectF.bottom = heightHalf + radius;
        rectF.left = 0;
        rectF.right = widthHalf - radius;
        rectF.top = heightHalf - radius;
        canvas.drawRect(rectF, paint);
        //"cutting off" right side of the image
        rectF.bottom = heightHalf + radius;
        rectF.left = widthHalf + radius;
        rectF.right = this.getMeasuredWidth();
        rectF.top = heightHalf - radius;
        canvas.drawRect(rectF, paint);
        //"cutting off" left-top arc of the image
        rectF.bottom = heightHalf + radius;
        rectF.left = widthHalf - radius;
        rectF.right= widthHalf + radius;
        rectF.top = heightHalf - radius;
        path.moveTo(widthHalf - radius, heightHalf);
        path.addArc(rectF, 180F, 90F);
        path.moveTo(widthHalf, heightHalf - radius);
        path.lineTo(widthHalf - radius, heightHalf - radius);
        path.lineTo(widthHalf - radius, heightHalf);
        canvas.drawPath(path, paint);
        //"cutting off" right-top arc of the image
        path.reset();
        path.moveTo(widthHalf + radius, heightHalf);
        path.addArc(rectF, 0F, -90F);
        path.moveTo(widthHalf, heightHalf - radius);
        path.lineTo(widthHalf + radius, heightHalf - radius);
        path.lineTo(widthHalf + radius, heightHalf);
        canvas.drawPath(path, paint);
        //"cutting off" left-bottom arc of the image
        path.reset();
        path.moveTo(widthHalf - radius, heightHalf);
        path.addArc(rectF, 180F, -90F);
        path.moveTo(widthHalf, heightHalf + radius);
        path.lineTo(widthHalf - radius, heightHalf + radius);
        path.lineTo(widthHalf - radius, heightHalf);
        canvas.drawPath(path, paint);
        //"cutting off" right-bottom arc of the image
        path.reset();
        path.moveTo(widthHalf + radius, heightHalf);
        path.addArc(rectF, 0F, 90F);
        path.moveTo(widthHalf, heightHalf + radius);
        path.lineTo(widthHalf + radius, heightHalf + radius);
        path.lineTo(widthHalf + radius, heightHalf);
        canvas.drawPath(path, paint);
    }
}
