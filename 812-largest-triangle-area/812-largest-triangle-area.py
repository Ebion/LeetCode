class Solution(object):
    def largestTriangleArea(self, points):
        """
        :type points: List[List[int]]
        :rtype: float
        """
        Area = 0
        iter_combi = [p for p in itertools.combinations(points, 3)]
        for point1, point2, point3 in iter_combi:
            x1, y1 = point1
            x2, y2 = point2
            x3, y3 = point3

            this_area = 0.5 * abs(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2))
            if (this_area > Area): 
                Area = this_area
        return Area