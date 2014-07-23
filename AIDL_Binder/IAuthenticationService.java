/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/housy/workSpace/ccdt_ott/itvision/src/com/ccdt/itvision/service/authentication/IAuthenticationService.aidl
 */

package com.ccdt.itvision.service.authentication;

public interface IAuthenticationService extends android.os.IInterface
{
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements
            com.ccdt.itvision.service.authentication.IAuthenticationService
    {
        private static final java.lang.String DESCRIPTOR = "com.ccdt.itvision.service.authentication.IAuthenticationService";

        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an
         * com.ccdt.itvision.service.authentication.IAuthenticationService
         * interface, generating a proxy if needed.
         */
        public static com.ccdt.itvision.service.authentication.IAuthenticationService asInterface(
                android.os.IBinder obj)
        {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.ccdt.itvision.service.authentication.IAuthenticationService))) {
                return ((com.ccdt.itvision.service.authentication.IAuthenticationService) iin);
            }
            return new com.ccdt.itvision.service.authentication.IAuthenticationService.Stub.Proxy(
                    obj);
        }

        @Override
        public android.os.IBinder asBinder()
        {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply,
                int flags) throws android.os.RemoteException
        {
            switch (code)
            {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_doAuth: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    java.lang.String _arg2;
                    _arg2 = data.readString();
                    this.doAuth(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_addAuthListener: {
                    data.enforceInterface(DESCRIPTOR);
                    com.ccdt.itvision.service.authentication.IAuthListener _arg0;
                    _arg0 = com.ccdt.itvision.service.authentication.IAuthListener.Stub
                            .asInterface(data.readStrongBinder());
                    this.addAuthListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_removeAuthListener: {
                    data.enforceInterface(DESCRIPTOR);
                    com.ccdt.itvision.service.authentication.IAuthListener _arg0;
                    _arg0 = com.ccdt.itvision.service.authentication.IAuthListener.Stub
                            .asInterface(data.readStrongBinder());
                    this.removeAuthListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_checkAuthStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.checkAuthStatus();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_doRegister: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    this.doRegister(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_addRegisterListener: {
                    data.enforceInterface(DESCRIPTOR);
                    com.ccdt.itvision.service.authentication.IRegisterListener _arg0;
                    _arg0 = com.ccdt.itvision.service.authentication.IRegisterListener.Stub
                            .asInterface(data.readStrongBinder());
                    this.addRegisterListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_removeRegisterListener: {
                    data.enforceInterface(DESCRIPTOR);
                    com.ccdt.itvision.service.authentication.IRegisterListener _arg0;
                    _arg0 = com.ccdt.itvision.service.authentication.IRegisterListener.Stub
                            .asInterface(data.readStrongBinder());
                    this.removeRegisterListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_checkRegisterStatus: {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.checkRegisterStatus();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements
                com.ccdt.itvision.service.authentication.IAuthenticationService
        {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote)
            {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder()
            {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor()
            {
                return DESCRIPTOR;
            }

            @Override
            public void doAuth(java.lang.String mac, java.lang.String businessType,
                    java.lang.String sn) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(mac);
                    _data.writeString(businessType);
                    _data.writeString(sn);
                    mRemote.transact(Stub.TRANSACTION_doAuth, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void addAuthListener(com.ccdt.itvision.service.authentication.IAuthListener l)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((l != null)) ? (l.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_addAuthListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void removeAuthListener(com.ccdt.itvision.service.authentication.IAuthListener l)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((l != null)) ? (l.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_removeAuthListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int checkAuthStatus() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_checkAuthStatus, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void doRegister(java.lang.String userName, java.lang.String password)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(userName);
                    _data.writeString(password);
                    mRemote.transact(Stub.TRANSACTION_doRegister, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void addRegisterListener(
                    com.ccdt.itvision.service.authentication.IRegisterListener l)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((l != null)) ? (l.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_addRegisterListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void removeRegisterListener(
                    com.ccdt.itvision.service.authentication.IRegisterListener l)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((l != null)) ? (l.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_removeRegisterListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int checkRegisterStatus() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_checkRegisterStatus, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_doAuth = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_addAuthListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_removeAuthListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_checkAuthStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_doRegister = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_addRegisterListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_removeRegisterListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
        static final int TRANSACTION_checkRegisterStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    }

    public void doAuth(java.lang.String mac, java.lang.String businessType, java.lang.String sn)
            throws android.os.RemoteException;

    public void addAuthListener(com.ccdt.itvision.service.authentication.IAuthListener l)
            throws android.os.RemoteException;

    public void removeAuthListener(com.ccdt.itvision.service.authentication.IAuthListener l)
            throws android.os.RemoteException;

    public int checkAuthStatus() throws android.os.RemoteException;

    public void doRegister(java.lang.String userName, java.lang.String password)
            throws android.os.RemoteException;

    public void addRegisterListener(com.ccdt.itvision.service.authentication.IRegisterListener l)
            throws android.os.RemoteException;

    public void removeRegisterListener(com.ccdt.itvision.service.authentication.IRegisterListener l)
            throws android.os.RemoteException;

    public int checkRegisterStatus() throws android.os.RemoteException;
}

