SELECT E.EMP_NO, E.EMP_NAME,
    case 
		when AVG(SCORE) >= 96 then 'S'
        when AVG(SCORE) >= 90 then 'A'
        when AVG(SCORE) >= 80 then 'B'
		else 'C'
	end  as 'GRADE',
    case 
		when AVG(SCORE) >= 96 then E.SAL*0.2
        when AVG(SCORE) >= 90 then E.SAL*0.15
        when AVG(SCORE) >= 80 then E.SAL*0.1
		else 0
	end  as 'BONUS'
FROM HR_EMPLOYEES E
    inner join HR_GRADE G on E.EMP_NO = G.EMP_NO
GROUP BY E.EMP_NO
ORDER BY E.EMP_NO;