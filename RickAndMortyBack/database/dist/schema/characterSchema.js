"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.characterSchema = void 0;
const mongoose_1 = require("mongoose");
exports.characterSchema = new mongoose_1.Schema({
    _id: { type: Number, required: true },
    name: { type: String, required: true },
    status: { type: String, required: true },
    species: { type: String, required: true },
    type: { type: String, required: true },
    gender: { type: String, required: true },
    image: { type: String, required: true },
    origin: [{ type: Number, ref: 'Location' }],
    location: [{ type: Number, ref: 'Location' }],
    episode: [{ type: Number, ref: 'Episode' }],
});
