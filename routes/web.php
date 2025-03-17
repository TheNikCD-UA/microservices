<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ProductController;

Route::get('/', function () {
    return view('welcome');
});

Route::prefix('/rest')->group(function () {
    Route::get('/items', [ProductController::class, 'index']);
    Route::post('/items', [ProductController::class, 'store']);
    Route::get('/items/{product:id}', [ProductController::class, 'show']);
    Route::put('/items/{product:id}', [ProductController::class, 'update']);
    Route::delete('/items/{product:id}', [ProductController::class, 'destroy']);
});
