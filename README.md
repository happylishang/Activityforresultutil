# activityforresultutil

用法：

        ActivityForResultUtil.startActivityForResult(activity,new Intent(activity,BActvityClass.class, new OnActivityResultListener() {
            @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                
            }
        }));
