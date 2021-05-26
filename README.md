# activityforresultutil



用法：

 1
       
         implementation ('io.github.happylishang:activityforresult:1.0.0')


 2
 
           ActivityForResultUtil.startActivityForResult(activity,new Intent(activity,BActvityClass.class, new OnActivityResultListener() {
               @Override
               public void onActivityResult(int requestCode, int resultCode, Intent data) {
                 //自行处理data数据
              }
           }));
