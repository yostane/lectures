const emberFirebaseConfig = {
  firebaseConfig: {
    apiKey: '',
    authDomain: '',
    projectId: '',
    storageBucket: '',
    messagingSenderId: '',
    appId: '',
    measurementId: '',
  },
  firestore: {
    emulator: {
      hostname: 'localhost',
      port: 8080,
    },
  },

  auth: {
    emulator: {
      hostname: 'localhost',
      port: 9099,
    },
  },
};

module.exports = emberFirebaseConfig;
