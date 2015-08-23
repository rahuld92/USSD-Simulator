package hekaton.balapkelerang.ussd;

public interface GenericAction {
	/**
	 * 
	 * @param inParameters array of 1 elemen, Object[0] will containing object that hold GenericAsync parameters
	 * @param outParameters array of 1 elemen, Object[0] will be returned and accessible in postExecute
	 */
	public void execute(Object[] inParameters, Object[] outParameters);

	/**
	 * 
	 * @param result will be filled with outParameters[0]
	 */
	public void postExecute(Object result);
}
