import app from './app';
import store from './config/index';

app.listen(store.PORT, () => {
  console.log(`Server listening on port ${store.PORT}`);
});
