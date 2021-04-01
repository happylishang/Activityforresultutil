# activityforresultutil



用法：

 1
    implementation 'com.netease.yanxuan:activityforresult:0.0.1'

 2
        ActivityForResultUtil.startActivityForResult(activity,new Intent(activity,BActvityClass.class, new OnActivityResultListener() {
            @Override
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
               //自行处理data数据
            }
        }));
