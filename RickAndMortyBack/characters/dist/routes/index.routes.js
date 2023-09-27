"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const controller_1 = __importDefault(require("../controller"));
const express_1 = require("express");
const router = (0, express_1.Router)();
router.get('/characters', controller_1.default.getCharactersList);
router.get('/characters/:id', controller_1.default.getCharacter);
exports.default = router;