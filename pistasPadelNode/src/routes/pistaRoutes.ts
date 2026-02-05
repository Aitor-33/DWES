import { Router } from 'express';
import { obtenerPistas, crearPista, obtenerPistasId } from '../controllers/pistaController';
const router = Router();
router.get('/pistas', obtenerPistas);
router.post('/pistas', crearPista);
router.get('pistas', obtenerPistasId);
export default router;