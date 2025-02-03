package com.dishcovery.project.service;

import java.util.List;

import com.dishcovery.project.domain.IngredientsVO;
import com.dishcovery.project.domain.MethodsVO;
import com.dishcovery.project.domain.RecipeBoardVO;
import com.dishcovery.project.domain.SituationsVO;
import com.dishcovery.project.domain.TypesVO;

public interface RecipeBoardService {
	 // ������ �Խñ� ���
    int createRecipeBoard(RecipeBoardVO recipeBoardVO);

    // ������ �Խñ� ��ȸ
    RecipeBoardVO getRecipeBoard(int recipeBoardId);

    // ������ �Խñ� ��� ��ȸ
    List<RecipeBoardVO> getBoardList();

    // ������ �Խñ� ����
    int updateRecipeBoard(RecipeBoardVO recipeBoard);

    // ������ �Խñ� ����
    int deleteRecipeBoard(int recipeBoardId);

    // ��ȸ�� ����
    int increaseViewCount(int recipeBoardId);

    List<RecipeBoardVO> selectAll();

    // Ư�� ������� ������ �Խñ� ��� ��ȸ
    List<RecipeBoardVO> getRecipeBoardsByMemberId(String memberId);

    // ī�װ��� ������ ��ȸ
    List<RecipeBoardVO> getRecipeBoardsByType(int typeId);

    List<RecipeBoardVO> getRecipeBoardsByIngredient(int ingredientId);

    List<RecipeBoardVO> getRecipeBoardsByMethod(int methodId);

    List<RecipeBoardVO> getRecipeBoardsBySituation(int situationId);

    List<TypesVO> getTypes();

    List<IngredientsVO> getIngredients();

    List<MethodsVO> getMethods();

    List<SituationsVO> getSituations();

	RecipeBoardVO getRecipeBoardsById(int recipeBoardId);
}