package com.egs.common.data.model.converter;

import com.egs.common.data.model.lcp.UserProfile;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by SahakBabayan on 12/5/2017.
 */
@Converter(autoApply = true)
public class UserProfileConverter implements AttributeConverter<UserProfile, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserProfile profile) {
        return profile.getValue();
    }

    @Override
    public UserProfile convertToEntityAttribute(Integer value) {
        return UserProfile.valueOf(value);
    }
}

