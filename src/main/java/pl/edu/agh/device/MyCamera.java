package pl.edu.agh.device;

import SmartHome.Camera;
import SmartHome.InvalidPhotoSize;
import SmartHome.PhotoSize;
import com.zeroc.Ice.Current;

public class MyCamera extends MyDevice implements Camera {
    public final static short BASIC_PHOTO_SIZE_X = 8;
    public final static short BASIC_PHOTO_SIZE_Y = 13;
    private final PhotoSize minPhotoSize = new PhotoSize((short) 1, (short)1);
    private final PhotoSize maxPhotoSize = new PhotoSize((short) 100, (short) 100);

    private PhotoSize photoSize = new PhotoSize(BASIC_PHOTO_SIZE_X, BASIC_PHOTO_SIZE_Y);

    @Override
    public PhotoSize getPhotoSize(Current current) {
        return photoSize;
    }

    @Override
    public void setPhotoSize(PhotoSize photoSize, Current current) throws InvalidPhotoSize {
        if (isTurnedOn(current)) {
            if (newSizeIsValid(photoSize)) {
                this.photoSize = photoSize;
            } else {
                throw new InvalidPhotoSize(minPhotoSize, maxPhotoSize, photoSize);
            }
        }
    }

    public boolean newSizeIsValid(PhotoSize photoSize) {
        return photoSize.x > 0 && photoSize.y > 0 && photoSize.x <= maxPhotoSize.x && photoSize.y <= maxPhotoSize.y;
    }

    @Override
    public short[] getPhoto(Current current) {
        if (isTurnedOn(current)) {
            short[] values = new short[photoSize.y * photoSize.x];
            for (short i = 0; i < photoSize.y * photoSize.x; i++) {
                values[i] = i;
            }
            return values;
        }
        else {
            return null;
        }
    }
}
