import mongoose from 'mongoose';
import store from '../config/index';
import { characterSchema } from '../schema/characterSchema';
import { locationSchema } from '../schema/locationSchema';
import { episodeSchema } from '../schema/episodeSchema';

const connection: mongoose.Connection = mongoose.createConnection(
  String(store.MONGO_URI)
);

export = {
  Character: connection.model('Character', characterSchema),
  Location: connection.model('Location', locationSchema),
  Episode: connection.model('Episode', episodeSchema),
};
