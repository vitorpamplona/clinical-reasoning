package org.opencds.cqf.fhir.cr.questionnaire.r4.helpers;

import jakarta.annotation.Nonnull;
import java.util.List;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.DataRequirement;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Questionnaire;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType;
import org.opencds.cqf.fhir.utility.Constants;

public class TestingHelper {
    static final String PROFILE_URL = "http://www.sample.com/profile/profileId";
    static final String LINK_ID = "profileId";
    static final QuestionnaireItemType QUESTIONNAIRE_ITEM_TYPE = QuestionnaireItemType.GROUP;
    static final String PROFILE_TITLE = "Profile Title";
    public static final String QUESTIONNAIRE_ID = "questionnaireId";
    public static final String CQF_EXTENSION_URL = "url";

    @Nonnull
    public static ElementDefinition withElementDefinition(String typeCode, String pathValue) {
        final ElementDefinition elementDefinition = new ElementDefinition().setPath(pathValue);
        final TypeRefComponent type = new TypeRefComponent();
        type.setCode(typeCode);
        elementDefinition.setType(List.of(type));
        return elementDefinition;
    }

    @Nonnull
    public static DataRequirement withActionInput() {
        final DataRequirement actionInput = new DataRequirement();
        final CanonicalType canonicalType = new CanonicalType();
        canonicalType.setValue(PROFILE_URL);
        actionInput.setProfile(List.of(canonicalType));
        return actionInput;
    }

    @Nonnull
    public static QuestionnaireItemComponent withQuestionnaireItemComponent() {
        return new QuestionnaireItemComponent()
                .setType(QUESTIONNAIRE_ITEM_TYPE)
                .setLinkId(LINK_ID)
                .setText(PROFILE_TITLE)
                .setRequired(false);
    }

    public static Questionnaire withQuestionnaire() {
        final Questionnaire questionnaire = new Questionnaire();
        final CanonicalType type = new CanonicalType(CQF_EXTENSION_URL);
        final Extension extension = new Extension(Constants.CQF_LIBRARY, type);
        questionnaire.addExtension(extension);
        questionnaire.setId(QUESTIONNAIRE_ID);
        questionnaire.setItem(QUESTIONNAIRE_SUB_ITEMS);
        return questionnaire;
    }

    public static final List<QuestionnaireItemComponent> QUESTIONNAIRE_SUB_ITEMS = List.of(
            new QuestionnaireItemComponent(), new QuestionnaireItemComponent(), new QuestionnaireItemComponent());
}
