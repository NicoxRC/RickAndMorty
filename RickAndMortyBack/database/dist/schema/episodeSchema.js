"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.episodeSchema = void 0;
const mongoose_1 = require("mongoose");
exports.episodeSchema = new mongoose_1.Schema({
    _id: { type: Number, require: true },
    name: { type: String, require: true },
    air_date: { type: String, require: true },
    episode: { type: String, require: true },
    characters: [{ type: Number, ref: 'Character' }],
});
