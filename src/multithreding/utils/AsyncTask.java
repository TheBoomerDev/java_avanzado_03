package multithreding.utils;

public interface AsyncTask<B,P,T> {
    P doInBackground(B...datos);
    void onProgressUpdate(P... progress);
    void onPostExecute(T result);
}
