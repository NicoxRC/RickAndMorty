export interface LocationsInterface {
  _id: number;
  name: string;
  type: string;
  dimension: string;
  residents: residentesType[];
}
type residentesType = {
  id: number;
  name: string;
};
