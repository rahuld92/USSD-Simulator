package hekaton.balapkelerang.ussd;

import com.github.kevinsawicki.http.HttpRequest;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	static enum InputType {NUMBER,URL};
	
	public static String URL = "http://10.107.147.132:3579/ussd/";
	public static String NUMBER = "08118711411";
	private String messageBuffer = "";

	@InjectView(R.id.display) TextView display;
	@InjectView(R.id.progressdialog) View progressDialog;
	@InjectView(R.id.ussdpanel) View ussdPanel;
	@InjectView(R.id.response) TextView response;
	@InjectView(R.id.request) EditText request;
	@InjectView(R.id.layer) View layer;
	
	private GenericAction callAction = new GenericAction() {
		@Override
		public void execute(Object[] inParameters, Object[] outParameters) {
			String text = ((CharSequence) inParameters[0]).toString();
			String url = Helper.createUrl(URL, NUMBER, "");
			String response = HttpRequest.get(url).body();
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//response = text;
			outParameters[0] = response;
		}
		
		@Override
		public void postExecute(Object result) {
			progressDialog.setVisibility(View.INVISIBLE);
			ussdPanel.setVisibility(View.VISIBLE);
			response.setText((String)result);
			request.requestFocus();
		}
	};
	
	private GenericAction sendAction = new GenericAction() {
		@Override
		public void execute(Object[] inParameters, Object[] outParameters) {
			String text = ((CharSequence) inParameters[0]).toString();
			if(!messageBuffer.isEmpty()) {
				messageBuffer += "*";
			}
			messageBuffer += text;
			String response = HttpRequest.get(Helper.createUrl(URL, NUMBER, messageBuffer)).body();
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//response = messageBuffer;
			outParameters[0] = response;
		}
		
		@Override
		public void postExecute(Object result) {
			progressDialog.setVisibility(View.INVISIBLE);
			ussdPanel.setVisibility(View.VISIBLE);
			response.setText((String)result);
			request.setText("");
			request.requestFocus();
			if(result.toString().contains("Terima Kasih")) {
				new GenericAsyncTask(new GenericAction() {
					@Override
					public void execute(Object[] inParameters, Object[] outParameters) {
						// TODO Auto-generated method stub
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					@Override
					public void postExecute(Object result) {
						reset();
					}
				}).execute(new Object[]{});
			}
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
    
    public void ussdSession() {
    	layer.setVisibility(View.VISIBLE);
    	progressDialog.setVisibility(View.VISIBLE);
    	display.setVisibility(View.INVISIBLE);
    }
    
    private void reset() {
    	progressDialog.setVisibility(View.INVISIBLE);
    	ussdPanel.setVisibility(View.INVISIBLE);
    	display.setVisibility(View.VISIBLE);
    	display.setText("");
    	request.setText("");
    	layer.setVisibility(View.INVISIBLE);
    	messageBuffer = "";
    }
    
    protected void showInputDialog(final InputType type, String title) {
		// get prompts.xml view
		LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
		View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
		((TextView)promptView.findViewById(R.id.inputtitle)).setText(title);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
		alertDialogBuilder.setView(promptView);

		final EditText editText = (EditText) promptView.findViewById(R.id.inputvalue);
		// setup a dialog window
		alertDialogBuilder.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						switch (type) {
						case NUMBER:
							NUMBER = editText.getText().toString();
							break;
						case URL:
							URL = editText.getText().toString();
							break;
						default:
							break;
						}
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		// create an alert dialog
		AlertDialog alert = alertDialogBuilder.create();
		alert.show();
	}
    
    @OnClick({R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,
    		  R.id.button6,R.id.button7,R.id.button8,R.id.button9}) 
    public void buttonPress(Button button) {
    	String buttonNumber = getResources().getResourceEntryName(button.getId());
    	String text = buttonNumber.replace("button", "");
    	display.setText(display.getText() + text);
    }
    
    @OnLongClick(R.id.button5)
    public boolean setNumber(Button button) {
    	showInputDialog(InputType.NUMBER, "Change Number");
    	return true;
    }
    
    @OnLongClick(R.id.button8)
    public boolean setURL(Button button) {
    	showInputDialog(InputType.URL, "Change URL");
    	return true;
    }
    
    @OnClick(R.id.buttonsharp)
    public void buttonSharp(Button button) {
    	display.setText(display.getText() + "#");
    }
    
    @OnClick(R.id.buttonstar)
    public void buttonStar(Button button) {
    	display.setText(display.getText() +"*");
    }
    
    @OnClick(R.id.buttonbackspace) 
    public void buttonBackspace(Button button) {
    	if(display.getText().length() > 0) {
    		CharSequence text = display.getText();
    		display.setText(text.subSequence(0, text.length()-1));
    	}
    }
    
    @OnLongClick(R.id.buttonbackspace)
    public boolean buttonLongBackspace(Button button) {
    	display.setText("");
    	return true;
    }
    
    @OnClick(R.id.buttoncancel)
    public void buttonCancel() {
    	reset();
    }
    
    @OnClick(R.id.buttonsend)
    public void buttonSend(Button button) {
    	ussdSession();
    	new GenericAsyncTask(sendAction).execute(new Object[]{request.getText()});
    }
    
    @OnClick(R.id.buttoncall)
    public void buttonCall(Button button) {
    	ussdSession();
    	new GenericAsyncTask(callAction).execute(new Object[]{display.getText()});
    }
}
