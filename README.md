### ImageEditer
The ImageEditer SDK is a powerful and multifaceted tool which enables you to equip your Android application with high-performant photo 
editing capabilities. The ImageEditer SDK is written in Java and can easily be customized to entirely blend with your CI and provide
your users with the exact feature set your use-case requires.

The below code snippet also shows all configurables, with some description.  

Call Intent
```java
        Intent editImage = new Intent(this, EditImageActivity.class);
        editImage.putExtra(EditImageActivity.EXTRA_IMAGE_PATHS, uri.getPath());
        startActivityForResult(editImage, EditImageActivity.REQ_IMAGE_EDITOR);
```
Add below code in onActivityResult 
```java
        switch (requestCode) {
                case EditImageActivity.REQ_IMAGE_EDITOR:
                    if (data != null) {
                        Uri editedImageUri = data.getParcelableExtra(EditImageActivity.SELECTED_IMAGES);
                     }
                    break;
            }
```
