import type { Document, Types } from 'mongoose';

export interface charactersInterface extends Document {
  _id: number;
  name: string;
  status: string;
  species: string;
  type: string;
  gender: string;
  image: string;
  origin: Types.ObjectId;
  location: Types.ObjectId;
  episode: Types.ObjectId[];
}
