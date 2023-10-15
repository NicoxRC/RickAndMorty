import type { Document, Types } from 'mongoose';

export interface LocationsInterface extends Document {
  _id: number;
  name: string;
  type: string;
  dimension: string;
  residents: Types.ObjectId[];
}
