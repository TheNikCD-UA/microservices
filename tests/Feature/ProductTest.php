<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;
use App\Models\Product;

class ProductTest extends TestCase
{
    public function test_to_get_all_products_data(): void
    {
        $response = $this->get('/rest/items')
            ->assertStatus(200)
            ->assertJsonStructure(
                [
                    '*' => [
                        "id",
                        "name",
                        "price",
                        "description",
                    ],

                ]
            );

    }

    public function test_for_add_product(): void
    {

        $product = Product::create([
            'name' => fake()->word(),
            'price' => fake()->numberBetween(0, 1000),
            'description' => fake()->sentence(12),
        ]);;

        $payload = [
            "name" => $product->name,
            "price" => $product->price,
            'description' => $product->description,
        ];

        $this->json('POST', 'rest/items', $payload)
            ->assertStatus(200)
            ->assertJson([
                'code' => '200',
                'message' => 'New Product created.',
            ]);
    }

    public function test_get_product_by_id(): void
    {
        Product::factory()->count(3)->create();
        $product_id = Product::get()->random()->id;
        $response = $this->get('/rest/items/' . $product_id)
            ->assertStatus(200)
            ->assertJsonStructure(
                [
                    '*' => [
                        "id",
                        "name",
                        "price",
                        "description",
                    ],
                ]
            );
    }

    public function test_for_update_product(): void
    {
        $payload = [
            "name" => fake()->word(),
            'price' => fake()->numberBetween(0, 1000),
            'description' => fake()->sentence(12),
            'updated_at' => fake()->date('Y-m-d', 'now'),

        ];
        $product_id = Product::get()->random()->id;

        $this->json('PUT', 'rest/items/' . $product_id, $payload)
            ->assertStatus(200)
            ->assertJson([
                'code' => '200',
                'message' => 'Product updated.',
            ]);
    }

    public function test_for_delete_product(): void
    {
        $product_id = Product::get()->random()->id;

        $this->json('DELETE', 'rest/items/' . $product_id)
            ->assertStatus(200)
            ->assertJson([
                'code' => '200',
                'message' => 'product removed successfully.',
            ]);
    }
}
