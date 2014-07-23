	private ServiceConnection mAuthenticationConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mAuthenticationService = IAuthenticationService.Stub.asInterface(service);
			Log.e("test", "onServiceConnected, " + service);
			Log.e("test", "onServiceConnected, " + mAuthenticationService);
			if (mAuthenticationService != null) {  
				try {
					mAuthenticationService.addAuthListener(mAuthListener);
					mHandler.sendEmptyMessage(HANLDE_MSG_DO_AUTHENTICATE);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		}
	};

bindService(new Intent(this, AuthenticationService.class), mAuthenticationConnection, BIND_AUTO_CREATE);
