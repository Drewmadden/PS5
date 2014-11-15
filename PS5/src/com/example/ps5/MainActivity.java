package com.example.ps5;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.text.Editable;
public class MainActivity extends Activity implements OnItemSelectedListener{
	
	EditText AnnualInvestment;
	EditText InterestRate;
	TextView FutureValue;
	Spinner Years;
	Object totalyrs;
	Button button;
	Integer[] nums = new Integer [75];
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AnnualInvestment = (EditText) findViewById(R.id.editText1);
		InterestRate = (EditText) findViewById(R.id.editText2);
		FutureValue = (TextView) findViewById(R.id.textView4);
		
		AnnualInvestment.addTextChangedListener(
				new TextWatcher(){
					@Override
					public void afterTextChanged(Editable editable) {FutureValue.setText(" "); }
					@Override
					public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3){}
					@Override
					public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
					});
					InterestRate.addTextChangedListener(
							new TextWatcher(){
							@Override
							public void afterTextChanged(Editable editable) {
								FutureValue.setText(" ");
							}
							@Override
							 public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
				            @Override
				            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {}
				        });
					 
						for (int i = 0; i < 75; i++) {
				            nums[i] = i + 1;
							}
						ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, nums);
				        Years = (Spinner) findViewById(R.id.spinner1);
				        Years.setAdapter(adapter);
				        Years.setOnItemSelectedListener(this);
				        Button button1 = (Button)findViewById(R.id.button1);
				        button1.setOnClickListener(new View.OnClickListener(){			        
	@Override
	public void onClick(View v) {
		   double a;
	        double rate;
	        Editable initial = AnnualInvestment.getText();
	        Editable rt = InterestRate.getText();

	        if (initial.length() != 0 && rt.length() != 0) {

	            a = Double.parseDouble(initial.toString());
	            rate = Double.parseDouble(rt.toString());
	            double result = (double) (a * Math.pow((1 + rate / 100), (Integer) totalyrs));
	            result = Math.round(result);
	            FutureValue.setText("Future Value is $ " + ((Double) result).toString());
	            System.out.println("result: " + result);
	        }
	    }
	});}

	 public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	        int position = Years.getSelectedItemPosition();
	        totalyrs = Years.getItemAtPosition(position);
	        FutureValue.setText(" "); 
	    }

	    public void onNothingSelected(AdapterView<?> arg0) {


	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	}