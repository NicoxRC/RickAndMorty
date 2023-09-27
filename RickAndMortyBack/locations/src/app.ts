import express from 'express';
import morgan from 'morgan';
import routes from './routes/index.routes';

const app = express();

app.use(express.json());
app.use(morgan('dev'));
app.use(routes);

export default app;
