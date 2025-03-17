<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Product;

class ProductController extends Controller
{
    public function index()
    {
        $products = Product::all();
        if ($products->isEmpty()) {
            return response()->json(Product::all(), 200);
        }
        return response()->json($products);

    }

    public function store(Request $request)
    {
        $product = new Product;
        $product->name = $request->name;
        $product->price = $request->price;
        $product->description = $request->description;

        $product->save();
        $response = [
            'code' => '200',
            'message' => 'New Product created.',
        ];
        return response()->json($response);

    }

    public function show(Product $product)
    {
        $product = Product::find($product);
        return response()->json($product);

    }

    public function update(Request $request, Product $product)
    {

        $product->update([
            'name' => $request->input('name'),
            'price' => $request->input('price'),
            'description' => $request->input('description'),
            'updated_at' => now()
        ]);
        $response = [
            'code' => '200',
            'message' => 'Product updated.',
        ];
        return response()->json($response);

    }

    public function destroy(Product $product)
    {
        $product = Product::where('id', $product->id)->delete();
        $response = [
            'code' => '200',
            'message' => 'Product removed successfully.',
        ];
        return response()->json($response);

    }
}
