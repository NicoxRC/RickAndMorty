import express from 'express';
import cors from 'cors';
import morgan from 'morgan';
import characterRoutes from './routes/character.routes';

const app = express();

app.use(cors());
app.use(morgan('dev'));
app.use(express.json());
app.use(
  express.urlencoded({ limit: '10mb', extended: true, parameterLimit: 50000 })
);
app.use(characterRoutes);

export default app;
