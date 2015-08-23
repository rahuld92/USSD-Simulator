package hekaton.balapkelerang.ussd;

import android.os.AsyncTask;

public class GenericAsyncTask extends AsyncTask<Object, Object, Object>  {
	private final GenericAction genericAction;
	private static final Object SENTINEL = new Object();
	
	public GenericAsyncTask(GenericAction doAction) {
		this.genericAction = doAction;
	}
	
	@Override
	protected Object doInBackground(Object... param) {
		Object[] output = new Object[1];
		try {
			
			genericAction.execute(param, output);
			
		} catch(Exception ex) {
			ex.getMessage();
			if(output[0] == null)
				output[0] = SENTINEL;
		}
		finally
		{
		}
		return output[0]; 
	}
	
	@Override
	protected void onProgressUpdate(Object... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	protected void onPostExecute(Object result) {
		if(result != SENTINEL) {
			genericAction.postExecute(result);
		}
	}

}
