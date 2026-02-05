import { DataTypes, Model } from 'sequelize';
import sequelize from '../config/database'

class Reservas extends Model {
public id!: number;
public pista_id!: number;
public fecha!: Date;
public precio_hora!:number;
public created_at!:Date;
public updated_at!:Date;
}

Reservas.init(
{
id: {
type: DataTypes.INTEGER,
autoIncrement: true,
primaryKey: true,
},
pista_id: {
type: DataTypes.INTEGER,
autoIncrement: false,
primaryKey: true,
},
fecha: {
type: DataTypes.DATE,
allowNull: false,
unique: true,
},
precio_hora: {
type: DataTypes.DECIMAL(7,2),
allowNull: false,
unique: true,
},
created_at: {
type: DataTypes.DATE,
allowNull: false,
unique: true,
},
updated_at: {
type: DataTypes.DATE,
allowNull: false,
unique: true,
},
},
{
sequelize,
tableName: 'reservas',
}
);
export default Reservas;