package com.example.shoaib.miwokapp;



public class Word{

        private String mDeafaultLanguage;

        private String mMovikLanguage;

        private int mImageResourseId = NO_IMAGE;

        private int mAudioResource;

        public static final int NO_IMAGE = -1;





        public Word(String defaultLanguage,String movikLanguage, int AudioResource){

            mDeafaultLanguage = defaultLanguage;
            mMovikLanguage = movikLanguage;
            mAudioResource = AudioResource;

        }

        public Word(String defaultLanguage,String movikLanguage, int imageResource, int AudioResource){

        mDeafaultLanguage = defaultLanguage;
        mMovikLanguage = movikLanguage;
        mImageResourseId = imageResource;
        mAudioResource = AudioResource;
        }

        public String getDefault(){
            return mDeafaultLanguage;
        }

        public String getMovik() {
            return mMovikLanguage;
        }

    public int getmImageResourseId() {
        return mImageResourseId;
    }

    public boolean hasImage(){
            return NO_IMAGE != mImageResourseId;
    }

    public int getmAudioResource(){
            return mAudioResource;
    }

 /*   @Override
    public String toString() {
        return "Word{" +
                "mDeafaultLanguage='" + mDeafaultLanguage + '\'' +
                ", mMovikLanguage='" +  + '\'' +
                ", mImageResourseId=" + mImageResourseId +
                ", mAudioResource=" + mAudioResource +
                '}';
    }*/
}
