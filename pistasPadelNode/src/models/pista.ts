import { DataTypes, Model } from 'sequelize';
import sequelize from '../config/database'

class Pista extends Model {
public id!: number;
public nombre!: string;
public tipo!: string;
public precio_hora!:number;
public created_at!:Date;
public updated_at!:Date;
}

Pista.init(
{
id: {
type: DataTypes.INTEGER,
autoIncrement: true,
primaryKey: true,
},
nombre: {
type: DataTypes.STRING,
allowNull: false,
},
tipo: {
type: DataTypes.ENUM('INDOOR', 'OUTDOOR'),
allowNull: false,
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
tableName: 'pistas',
}
);
export default Pista;