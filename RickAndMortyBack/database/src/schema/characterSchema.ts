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
  origin: { id: Number, ref: 'Location' },
  location: { id: Number, ref: 'Location' },
  epidose: [{ type: Number, ref: 'Episode' }],
});

characterSchema.statics.list = async function () {
  return await this.find()
    .populate('origin', ['_id', 'name'])
    .populate('location', ['_id', 'name'])
    .populate('episode', ['_id', 'name']);
};

characterSchema.statics.get = async function (id: number) {
  return await this.findById(id)
    .populate('origin', ['_id', 'name'])
    .populate('location', ['_id', 'name'])
    .populate('episode', ['_id', 'name']);
};
