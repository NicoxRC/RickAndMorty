import dotenv from 'dotenv';
dotenv.config();

export = {
  MONGO_URI: process.env.MONGO_URI,
};
