function getUserPreferences(callbackFn) {
  return setTimeout(() => {
    callbackFn({
      theme: "dusk",
    });
  }, 1000);
}

function log(value) {
  console.log(value);
}

// log("start");

// getUserPreferences(preferences => {
//   return log(preferences.theme);
// });

// getUserPreferences(log);

function getMusic(theme, callbackFn) { // callbackFunctionStyle
  setTimeout(() => {
    if (theme === 'dusk') {
        callbackFn({
        album: 'music for airports',
      });
    } else {
      callbackFn({
        album: 'kind of blue',
      });
    }
  }, 1000);
}

// getUserPreferences(preferences => {
//   return getMusic(preferences.theme, music => {
//     console.log(music.album);
//   });
// });

function getUserPreferencesPromise(searchMusic) { // promiseStyle
  const preferences = new Promise((res, rej) => {
    const musicName = searchMusic;
    if (musicName === 'dusk') {
      res({
        theme: 'dusk',
      });
    } else {
        rej(new Error('No music found!! ' + musicName));
      }
  });
  return preferences;
}

getUserPreferencesPromise('lion').then(preferences => {
  // console.log(preferences.theme);
  return getMusic(preferences.theme, music => {
    console.log(music.album);
  });
}).catch(err => {
  console.log(err);
});