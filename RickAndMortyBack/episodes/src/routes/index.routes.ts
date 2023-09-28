import controller from '../controller';
import { Router } from 'express';

const router = Router();

router.get('/episodes', controller.getEpisodesList);
router.get('/episodes/:id', controller.getEpisode);

export default router;
