import express from 'express';
import morgan from 'morgan';
import { createProxyMiddleware } from 'http-proxy-middleware';

const app = express();

app.use(express.json());
app.use(morgan('dev'));
app.use(
  '/characters',
  createProxyMiddleware({
    target: 'http://localhost:3002',
    changeOrigin: true,
  })
);
app.use(
  '/locations',
  createProxyMiddleware({
    target: 'http://localhost:3003',
    changeOrigin: true,
  })
);
app.use(
  '/episodes',
  createProxyMiddleware({
    target: 'http://localhost:3004',
    changeOrigin: true,
  })
);

export default app;
