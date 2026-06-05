package co.istad.elearning.features.category.dto;

public record CategoryResponse(
        Integer id,
        String name,
        Boolean isDeleted
) {
}
