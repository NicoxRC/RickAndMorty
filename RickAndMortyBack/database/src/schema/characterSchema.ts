import { Schema } from 'mongoose';
import type { charactersInterface } from '../interfaces/characters';

export const characterSchema = new Schema<charactersInterface>({
  _id: { type: Number, required: true },
  name: { type: String, required: true },
  status: { type: String, required: true },
  species: { type: String, required: true },
  type: { type: String, required: true },
  gender: { type: String, required: true },
  image: { type: String, required: true },
  // origin: { id: Number, ref: 'Locaktion' },
  // location: { id: Number, ref: 'Location' },
  // episode: [{ type: Number, ref: 'Episode' }],
});
