import { Schema } from 'mongoose';
import type { LocationsInterface } from '../interfaces/locations';

export const locationSchema = new Schema<LocationsInterface>({
  _id: { type: Number, required: true },
  name: { type: String, required: true },
  type: { type: String, required: true },
  dimension: { type: String, required: true },
  residents: [{ type: Number, ref: 'Character' }],
});
