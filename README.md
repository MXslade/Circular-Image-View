# Circular-Image-View
This is a custom android library which can be used to show imageView in circular mode. There are still some issues with background-color of the view. So, if you have an idea how to fix that please make a pull-request! But in another aspects it works fine).

To use that library to the following:

Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
Add the dependency:
dependencies {
	        implementation 'com.github.MXslade:Circular-Image-View:0.1'
}
