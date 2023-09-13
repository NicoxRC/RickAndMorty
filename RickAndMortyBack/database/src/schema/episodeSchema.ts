import { Schema } from 'mongoose';
import type { EpisodesInterface } from '../interfaces/episodes';

export const episodeSchema = new Schema<EpisodesInterface>({
  _id: { type: Number, require: true },
  name: { type: String, require: true },
  air_date: { type: String, require: true },
  episode: { type: String, require: true },
  characters: [{ type: Number, ref: 'Character' }],
});
