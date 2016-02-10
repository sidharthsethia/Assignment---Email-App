package io.getstrike.strike;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

public class MaterialDialogProcessing {
	
	private static Dialog mDialog;

	public static void show(final Context context){


            if(!(mDialog!=null&&mDialog.isShowing())) {
                    mDialog = new Dialog(context);
                    View localView = LayoutInflater.from(context).inflate(R.layout.progressdialog2_layout,null);
                    mDialog.requestWindowFeature(1);
                    mDialog.setContentView(localView);
                    mDialog.getWindow();
                    mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(255));
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
            }
	}
	
    public static void dismiss(){
    	if(mDialog!=null&&mDialog.isShowing()){ mDialog.dismiss(); }
		
	}

}
