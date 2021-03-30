package com.snail.activityforresult;

import android.content.Intent;

/**
 * Author: snail
 * Data: 3/29/21.
 * Des:
 * version:
 */

public  interface OnActivityResultListener {

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
