package com.myth.cici.wiget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.StackView;

import com.myth.cici.R;
import com.myth.cici.adapter.IntroAdapter;
import com.myth.cici.util.ResizeUtil;

public class IntroductionView extends RelativeLayout
{


    private Context mContext;

    final int[] mColors = {R.drawable.intro00, R.drawable.intro01,R.drawable.intro02,R.drawable.intro03,R.drawable.intro04,R.drawable.intro05};

    public IntroductionView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public IntroductionView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public IntroductionView(Context context)
    {
        super(context);
        mContext = context;
        initView();
    }
    
    private void layoutItemContainer(View itemContainer)
    {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) itemContainer.getLayoutParams();
        params.width =  LayoutParams.MATCH_PARENT;
        params.height = ResizeUtil.resize(mContext, 864);
        itemContainer.setLayoutParams(params);
    }

	private void initView()
    {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.layout_intro, null);
        
        final StackView stackView = (StackView)root. findViewById(R.id.stack_view);  
        layoutItemContainer(stackView);
        

        IntroAdapter colorAdapter = new IntroAdapter(mContext, mColors);
        stackView.setAdapter(colorAdapter);  
          

        addView(root, new LayoutParams(-1, -1));
    }  
      


}
