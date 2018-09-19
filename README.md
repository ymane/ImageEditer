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



## Release notes

1.0.0 
First Release.


## License

```
Copyright 2018 yogesh mane

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
