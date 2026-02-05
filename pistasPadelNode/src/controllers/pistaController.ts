// - POST /pistas → crear pista
// - GET /pistas → listar
// - GET /pistas/:id → obtener una
// - PUT /pistas/:id → actualizar
// - DELETE /pistas/:id → eliminar

import { Request, Response } from 'express';
import Pista from '../models/pista';


//post para crear pista
export const crearPista = async (req: Request, res: Response) => {
    const { nombre, tipo, precio_hora } = req.body;
    const nuevaPista = await Pista.create({ nombre, tipo, precio_hora });
    res.status(201).json(nuevaPista);
};

//get para recoger todas las pistas
export const obtenerPistas = async (req: Request, res: Response) => {
    const pista = await Pista.findAll();
    res.json(pista);
};

//get de pista por su id
export const obtenerPistasId = async (req: Request, res: Response) => {
    const pista = await Pista.findByPk(req.params.id);

    if (!pista) {

        return res.status(404).json({ message: 'Pista no encontrada' });

    }

    res.json(pista);

};