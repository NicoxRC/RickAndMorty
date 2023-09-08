import { Schema } from 'mongoose';
import type { CharactersInterface } from '../interfaces/characters';

export const characterSchema = new Schema<CharactersInterface>({
  _id: { type: Number, required: true },
  name: { type: String, required: true },
  status: { type: String, required: true },
  species: { type: String, required: true },
  type: { type: String, required: true },
  gender: { type: String, required: true },
  image: { type: String, required: true },
  origin: [{ type: Number, ref: 'Location' }],
  location: [{ type: Number, ref: 'Location' }],
  episode: [{ type: Number, ref: 'Episode' }],
});
