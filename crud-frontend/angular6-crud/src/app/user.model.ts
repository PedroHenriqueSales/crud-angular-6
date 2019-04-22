import { Phone } from "./phone.model";
import { Address } from "./address.model";

export class User{

    id: number;
    name: string;
    age: number;
    phones: Phone[];
    address: Address;

}